/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sara.controlador;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.mail.Part;
import sara.entity.Categoria;
import sara.entity.Vehiculo;
import sara.facade.CategoriaFacadeLocal;
import sara.facade.VehiculoFacadeLocal;

/**
 *
 * @author mompo
 */
@Named(value = "categoriaView")
@ViewScoped
public class CategoriaView implements Serializable {

    @EJB
    private CategoriaFacadeLocal categoriaFacadeLocal;

    @EJB
    private VehiculoFacadeLocal vehiculoFacadeLocal;

    private Part filePart;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private ArrayList<Categoria> listaCategorias = new ArrayList<>();
    private Categoria categoriaSelect = new Categoria();

    public CategoriaView() {
    }

    @PostConstruct
    public void cargaCategorias() {
        try {
            listaCategorias.addAll(categoriaFacadeLocal.findAll());
            categoriaSelect = categoriaFacadeLocal.find(1);
        } catch (Exception e) {
            System.out.println("edu.webapp1966781b.controlador.CategoriasView.cargaCategorias() " + e.getMessage());
        }
    }

    public void seleccionCategoria(int id) {
        try {
            categoriaSelect = categoriaFacadeLocal.find(id);
        } catch (Exception e) {
            System.out.println("edu.webapp1966781b.controlador.CategoriasView.seleccionCategoria() " + e.getMessage());
        }
    }

    public int cantidadVehiculosCategoria(int fk_vehiculo) {
        try {
            return categoriaFacadeLocal.cantidadVehiculosCategoria(fk_vehiculo);
        } catch (Exception e) {
            System.out.println("edu.webapp1966781b.controlador.CategoriasView.catidadproductoscategoria() " + e.getMessage());
            return 0;
        }
    }

    public List<Vehiculo> listaVehiculos() {
        try {
            return vehiculoFacadeLocal.listaVehiculosPorcategoria(categoriaSelect.getCaid());
        } catch (Exception e) {
            System.out.println("edu.webapp1966781b.controlador.CategoriasView.listaProductos() " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public Part getFilePart() {
        return filePart;
    }

    public void setFilePart(Part filePart) {
        this.filePart = filePart;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(ArrayList<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public Categoria getCategoriaSelect() {
        return categoriaSelect;
    }

    public void setCategoriaSelect(Categoria categoriaSelect) {
        this.categoriaSelect = categoriaSelect;
    }
    
}
