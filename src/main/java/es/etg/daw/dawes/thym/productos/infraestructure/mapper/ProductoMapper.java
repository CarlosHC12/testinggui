package es.etg.daw.dawes.thym.productos.infraestructure.mapper;

import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.thym.productos.domain.model.Producto;
import es.etg.daw.dawes.thym.productos.domain.model.ProductoId;
import es.etg.daw.dawes.thym.productos.infraestructure.api.dto.ProductoResponse;

public class ProductoMapper {
    
    public static List<Producto> toDomain(List<ProductoResponse> lista){
        List<Producto> lp = new ArrayList<>();
        if (lista == null) {
            return lp;
        }
        for(ProductoResponse pe: lista){
            lp.add(toDomain(pe));
        }
        return lp;
    }

    public static Producto toDomain(ProductoResponse p){
        if (p == null) return null;

        ProductoId id = (p.getId() != null) ? new ProductoId(p.getId()) : null;
        double precio = (p.getPrecio() != null) ? p.getPrecio() : 0.0;

        return Producto.builder()
                .id(id)
                .nombre(p.getNombre())
                .precio(precio)
                .build();
    }
}