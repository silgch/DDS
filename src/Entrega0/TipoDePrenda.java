package prendas;


public enum TipoDePrenda {

    ZAPATOS(Categoria.CALZADO){
        public boolean puedeSerDeMaterial(Material material){
            return material == Material.CUERO || material == Material.CUERINA;
        }
    },

    ZAPATILLAS(Categoria.CALZADO){
        public boolean puedeSerDeMaterial(Material material){
            return material == Material.CUERO || material == Material.CUERINA|| material == Material.LONA;
        }
    },
    BOTAS(Categoria.CALZADO){
        public boolean puedeSerDeMaterial(Material material){
            return material == Material.CUERO || material == Material.CUERINA;
        }
    },

    CAMISA(Categoria.PARTE_SUPERIOR){
        public boolean puedeSerDeMaterial(Material material){
            return material == Material.SEDA || material == Material.ALGODON;
        }
    },

    REMERA(Categoria.PARTE_SUPERIOR){
        public boolean puedeSerDeMaterial(Material material){
            return material == Material.SEDA || material == Material.ALGODON;
        }
    },

    PANTALON(Categoria.PARTE_INFERIOR){
        public boolean puedeSerDeMaterial(Material material){
            return material == Material.CORDEROY || material == Material.CUERO || material == Material.CUERINA|| material == Material.JEAN|| material == Material.LINO;
        }
    },
     LENTES(Categoria.ACCESORIOS){
        public boolean puedeSerDeMaterial(Material material){
            return material == Material.PLASTICO;
    }
     },
    RELOJ(Categoria.ACCESORIOS){
        public boolean puedeSerDeMaterial(Material material){
            return material == Material.ORO || material == Material.PLATA
            || material == Material.PLASTICO;
        }
    };

    private Categoria categoria;
	//Constructor: 
    TipoDePrenda(Categoria categoria) {
        this.categoria = categoria;
    }

    public abstract boolean puedeSerDeMaterial(Material material);

    public Categoria getCategoria() {
        return categoria;
    }

}