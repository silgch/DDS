package guardarropas;

import static java.util.Objects.requireNonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;
import com.google.common.collect.*; ///Esta bien instalado Guava?
import Entrega0.Prenda;
import Entrega0.Categoria;
import uniformes.Atuendo;
import Exception.CategoriaInvalidaException;


//Cada Usuario tiene uno o mas guardarropas.
//Cuando un usuario crea una prenda, se la incluye en su guardarropas, mediante el metodo agregarAGuardarropas.
public class Guardarropa {
    private List<Prenda> prendasSuperiores;
    private List<Prenda> prendasInferiores;
    private List<Prenda> calzados;
    private List<List<Prenda>> listaDelistasDePrendas;
    private List<Atuendo> atuendos;
    private Atuendo atuendo1;
    
    //Constructor:
    public Guardarropa() {
        this.prendasSuperiores = new ArrayList<Prenda>();
        this.prendasInferiores = new ArrayList<Prenda>();
        this.calzados = new ArrayList<Prenda>();
        this.atuendos = new ArrayList<Atuendo>();
        this.TodasLasPrendasDelGuardarropas = new ArrayList<List<Prenda>>(); // es una lista con todas las listas de prendas.
    }
    
    public void agregarAGuardarropas(Prenda prenda) {
        switch (prenda.getCategoria()) {
            case PARTE_SUPERIOR:
                this.agregarPrendaSuperior(prenda);
                break;
            case PARTE_INFERIOR:
                this.agregarPrendaInferior(prenda);
                break;
            case CALZADO:
                this.agregarCalzado(prenda);
                break;
            default:
                throw new CategoriaInvalidaException("Ha ingresado una categoria Invalida.");
        }

        //Estos Metodos se utilizan para agregar a la lista de la categoria correspondiente en el guardarropas
        public Guardarropa agregarPrendaInferior(Prenda _prenda) {
            this.prendasInferiores.add(_prenda);
            return this;
        }

        public Guardarropa agregarCalzado(Prenda _prenda) {
            this.calzados.add(_prenda);
            return this;
        }
        public Guardarropa agregarPrendaSuperior(Prenda prenda) {
            this.prendasSuperiores.add(prenda);
            return this;
        }

        
        /////
        public List<Prenda> getPrendaSuperiores(){
            return this.prendasSuperiores;
        }
        ///// porque no me toma la lista de listas???? VER  ¿ESTA BIEN LA DEPENDENCIA GUAVA?  VEEEEER
        
        public Guardarropa sugerir(){
            this.listaDelistasDePrendas = Lists.cartesianProduct
            							(this.prendasSuperiores,this.prendasInferiores,this.calzados);

            for(int i=0; i < this.getTamañoListaDeListasDePrendas; i++){
                List<Prenda> unAtuendo = this.getTamañoListaDeListasDePrendas.get(i);
                //DEVUELVE UNA DE LAS POSIBLES COMBINACIONES
                this.atuendos.add(new Atuendo(unAtuendo.get(0),unAtuendo.get(1),unAtuendo.get(2))); 


            }
            return this;

        }

        public int getTamañoListaDeListasDePrendas(){
            return listaDelistasDePrendas.size();
        }

        public List<Atuendo> getAtuendos(){
            return this.atuendos;

        }
}