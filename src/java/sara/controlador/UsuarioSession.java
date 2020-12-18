package sara.controlador;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.primefaces.PrimeFaces;
import sara.entity.Usuario;
import sara.facade.UsuarioFacadeLocal;

/**
 *
 * @author mompo
 */
@Named(value = "usuarioSession")
@SessionScoped
public class UsuarioSession implements Serializable {

    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;

    private String usuarioIn;
    private String passIn;
    private Usuario usuingresar = new Usuario();
    

    public UsuarioSession() {
    }

    public void inicioSession() {
        String mensajeAlerta = "";
        try {
            usuingresar = usuarioFacadeLocal.loginUsuario(usuarioIn, passIn);
            if (usuingresar.getUsuid() == null) {
                mensajeAlerta = "swal('Verifique sus datos', 'Intente de nuevo', 'error');";
            } else {
                FacesContext facesContext = FacesContext.getCurrentInstance();
                facesContext.getExternalContext().redirect("/sarastransporte/principal/index.xhtml");
            }

        } catch (Exception e) {
            System.out.println("Error UsuarioSesion:inicioSession " + e.getMessage());
            mensajeAlerta = "swal('Verifique sus datos', 'Intente de nuevo', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeAlerta);
    }
    public void cerraSesion() {
        usuingresar = null;
        ExternalContext ext = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ext.getRequestContextPath();

        try {
            ((HttpSession) ext.getSession(false)).invalidate();
            ext.redirect(ctxPath + "/index.xhtml");
        } catch (IOException e) {
            System.out.println("Error UsuarioSesion:cerraSesion " + e.getMessage());
        }

    }

    public String getUsuarioIn() {
        return usuarioIn;
    }

    public void setUsuarioIn(String usuarioIn) {
        this.usuarioIn = usuarioIn;
    }

    public String getPassIn() {
        return passIn;
    }

    public void setPassIn(String passIn) {
        this.passIn = passIn;
    }

    public Usuario getUsuingresar() {
        return usuingresar;
    }

    public void setUsuingresar(Usuario usuingresar) {
        this.usuingresar = usuingresar;
    }


}
