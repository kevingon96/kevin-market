package com.kevin.market.persintence;

import com.kevin.market.domain.Purchase;
import com.kevin.market.domain.repository.PurchaseRepository;
import com.kevin.market.persintence.crud.CompraCrudRepository;
import com.kevin.market.persintence.entity.Compra;
import com.kevin.market.persintence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchase((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> purchaseMapper.toPurchase(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return purchaseMapper.toPurchase(compraCrudRepository.save(compra));
    }
}
