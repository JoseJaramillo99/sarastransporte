/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sara.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;
import sara.entity.Categoria;
import sara.entity.Vehiculo;
import sara.facade.CategoriaFacadeLocal;
import sara.facade.VehiculoFacadeLocal;

/**
 *
 * @author mompo
 */
@Named(value = "vehiculoView")
@ViewScoped
public class vehiculoView implements Serializable {
    
    @EJB
    VehiculoFacadeLocal vehiculoFacadeLocal;

    @EJB
    private CategoriaFacadeLocal categoriaFacadeLocal;

    @Inject
    private CategoriaView categoriaView;

    private ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
    private Vehiculo vehiculoNuevo = new Vehiculo();
    private int id_categoria = 0;

    /**
     * Creates a new instance of ProductosView
     */
    @PostConstruct
    public void cargaInicialProductos() {
        listaVehiculos.addAll(vehiculoFacadeLocal.listaVehiculosPorcategoria(1));
    }

    public void nuevoVehiculo() {
        try {
            Categoria cateIn = categoriaFacadeLocal.find(id_categoria);
            vehiculoNuevo.setCaid(cateIn);
            vehiculoFacadeLocal.create(vehiculoNuevo);
        } catch (Exception e) {
            System.out.println("edu.webapp1966781b.controlador.ProductoView.nuevoProducto() " + e.getMessage());
        }
        PrimeFaces.current().executeScript("$('#myModal').hide();");
    }

    public void removerVehiculo(Vehiculo vehiRemov) {
        String mensajeAlerta = "";
        try {
            vehiculoFacadeLocal.remove(vehiRemov);
            listaVehiculos.remove(vehiRemov);
            mensajeAlerta = "swal('Removido el producto', '" + vehiRemov.getVehmarca() + ' ' + vehiRemov.getVehplaca() + "', 'success');";
        } catch (Exception e) {
            mensajeAlerta = "swal('Problemas eliminando ', '" + vehiRemov.getVehmarca() + ' ' + vehiRemov.getVehplaca() + "', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeAlerta);

    }


    public vehiculoView() {
    }

    public CategoriaView getCategoriaView() {
        return categoriaView;
    }

    public void setCategoriaView(CategoriaView categoriaView) {
        this.categoriaView = categoriaView;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public Vehiculo getVehiculoNuevo() {
        return vehiculoNuevo;
    }

    public void setVehiculoNuevo(Vehiculo vehiculoNuevo) {
        this.vehiculoNuevo = vehiculoNuevo;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    
  
    
}
