package Componentes;


public enum TipoDePrenda {

    ZAPATOS(Categoria.CALZADO){
    	@Override
        public void puedeSerDeMaterial(Material material){
       		boolean check=false;
    		try {
            check= (material == Material.CUERO || material == Material.CUERINA);
            if(!check) {
            	throw new IllegalArgumentException("Material no admisible para TipoDePrenda");
            }
    		}
    		catch(IllegalArgumentException e) {
    			System.out.println(e);
    		}
    	}
    },

    ZAPATILLAS(Categoria.CALZADO){
    	@Override
        public void puedeSerDeMaterial(Material material){
       		boolean check=false;
    		try {
            check= (material == Material.CUERO || material == Material.CUERINA|| material == Material.LONA);
            if(!check) {
            	throw new IllegalArgumentException("Material no admisible para TipoDePrenda");
            }
    		}
    		catch(IllegalArgumentException e) {
    			System.out.println(e);
    		}
    	}
    },
    BOTAS(Categoria.CALZADO){
    	@Override
        public void puedeSerDeMaterial(Material material){
       		boolean check=false;
    		try {
            check= (material == Material.CUERO || material == Material.CUERINA);
            if(!check) {
            	throw new IllegalArgumentException("Material no admisible para TipoDePrenda");
            }
    		}
    		catch(IllegalArgumentException e) {
    			System.out.println(e);
    		}
    	}
    },

    CAMISA(Categoria.PARTE_SUPERIOR){
    	@Override
        public void puedeSerDeMaterial(Material material){
       		boolean check=false;
    		try {
            check= (material == Material.SEDA || material == Material.ALGODON);
            if(!check) {
            	throw new IllegalArgumentException("Material no admisible para TipoDePrenda");
            }
    		}
    		catch(IllegalArgumentException e) {
    			System.out.println(e);
    		}
    	}
    },

    REMERA(Categoria.PARTE_SUPERIOR){
    	@Override
        public void puedeSerDeMaterial(Material material){
       		boolean check=false;
    		try {
            check= (material == Material.SEDA || material == Material.ALGODON);
            if(!check) {
            	throw new IllegalArgumentException("Material no admisible para TipoDePrenda");
            }
    		}
    		catch(IllegalArgumentException e) {
    			System.out.println(e);
    		}
    	}
    },

    PANTALON(Categoria.PARTE_INFERIOR){
    	@Override
        public void puedeSerDeMaterial(Material material){
       		boolean check=false;
    		try {
            check= (material == Material.CORDEROY || material == Material.CUERO || material == Material.CUERINA|| material == Material.JEAN|| material == Material.LINO);
            if(!check) {
            	throw new IllegalArgumentException("Material no admisible para TipoDePrenda");
            }
    		}
    		catch(IllegalArgumentException e) {
    			System.out.println(e);
    		}
    	}
    },
     LENTES(Categoria.ACCESORIOS){
    	@Override
        public void puedeSerDeMaterial(Material material){
       		boolean check=false;
    		try {
            check= (material == Material.PLASTICO);
            if(!check) {
            	throw new IllegalArgumentException("Material no admisible para TipoDePrenda");
            }
    		}
    		catch(IllegalArgumentException e) {
    			System.out.println(e);
    		}
    	}
    },
    RELOJ(Categoria.ACCESORIOS){
    	@Override
        public void puedeSerDeMaterial(Material material){
    		boolean check=false;
    		try {
            check= (material == Material.ORO || material == Material.PLATA
            || material == Material.PLASTICO);
            if(!check) {
            	throw new IllegalArgumentException("Material no admisible para TipoDePrenda");
            }
    		}
    		catch(IllegalArgumentException e) {
    			System.out.println(e);
    		}
    	}
    };
//----------------------------------------------------------------------------------
    
	private Categoria categoria;
    
	//Constructor: 
    TipoDePrenda(Categoria categoria) {
        this.categoria = categoria;
    }

    public abstract void puedeSerDeMaterial(Material material);

    public Categoria getCategoria() {
        return categoria;
    }

}