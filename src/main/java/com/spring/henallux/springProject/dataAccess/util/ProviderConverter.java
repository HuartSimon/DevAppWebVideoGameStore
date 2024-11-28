package com.spring.henallux.springProject.dataAccess.util;

import com.spring.henallux.springProject.dataAccess.entity.*;
import com.spring.henallux.springProject.dataAccess.entity.LanguageEntity;
import com.spring.henallux.springProject.model.*;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;

@Component
public class ProviderConverter {

    //private CustomDozerMapper mapper = new CustomDozerMapper(); // doesn't work
    private DozerBeanMapper mapper = new DozerBeanMapper();

    public UserEntity userModelToUserEntity(User user) {
        UserEntity userEntity = mapper.map(user, UserEntity.class);
        userEntity.setAccountNonExpired(user.isAccountNonExpired());
        userEntity.setAccountNonLocked(user.isAccountNonLocked());
        userEntity.setCredentialsNonExpired(user.isCredentialsNonExpired());
        userEntity.setEnabled(user.isEnabled());

        String authorities = "";
        for(GrantedAuthority authority : user.getAuthorities()){
            authorities += authority.getAuthority() + ",";
        }

        userEntity.setAuthorities(authorities);

        return userEntity;
    }

    public User userEntityToUserModel(UserEntity userEntity) {
        User user = mapper.map(userEntity, User.class);
        user.setAccountNonExpired(userEntity.getAccountNonExpired());
        user.setAccountNonLocked(userEntity.getAccountNonLocked());
        user.setCredentialsNonExpired(userEntity.getCredentialsNonExpired());
        user.setEnabled(userEntity.getEnabled());
        user.setAuthorities(userEntity.getAuthorities());

        return user;
    }

    public Language languageEntityToLanguageModel(LanguageEntity languageEntity) {
        return mapper.map(languageEntity, Language.class);
    }

    public LanguageEntity languageModelToLanguageEntity(Language language) {
        return mapper.map(language, LanguageEntity.class);
    }

    public Translation translationEntityToTranslationModel(TranslationEntity translationEntity) {
        return mapper.map(translationEntity, Translation.class);
    }

    public TranslationEntity translationModelToTranslationEntity(Translation translation) {
        return mapper.map(translation, TranslationEntity.class);
    }

    public OrderLine orderLineEntityToOrderLineModel(OrderLineEntity orderLineEntity) {

        OrderLine orderLine = new OrderLine();
        orderLine.setId(orderLineEntity.getId());
        orderLine.setDiscount(orderLineEntity.getDiscount());
        orderLine.setOrder(orderEntityToOrderModel(orderLineEntity.getOrder()));
        orderLine.setPrice(orderLineEntity.getPrice());
        orderLine.setQuantity(orderLineEntity.getQuantity());
        orderLine.setProduct(productEntityToProductModel(orderLineEntity.getProduct()));

        return orderLine;

        //return mapper.map(orderLineEntity, OrderLine.class);
    }

    public OrderLineEntity orderLineModelToOrderLineEntity(OrderLine orderLine) {
        OrderLineEntity orderLineEntity = new OrderLineEntity();
        orderLineEntity.setOrder(orderModelToOrderEntity(orderLine.getOrder()));
        orderLineEntity.setId(orderLine.getId());
        orderLineEntity.setDiscount(orderLineEntity.getDiscount());
        orderLineEntity.setProduct(productModelToProductEntity(orderLine.getProduct()));
        orderLineEntity.setPrice(orderLine.getPrice());
        orderLineEntity.setQuantity(orderLine.getQuantity());

        return orderLineEntity;

        //return mapper.map(orderLine, OrderLineEntity.class);
    }

    public Order orderEntityToOrderModel(OrderEntity orderEntity) {
        Order order = new Order();
        order.setUser(userEntityToUserModel(orderEntity.getUser()));
        order.setOrderDate(orderEntity.getOrderDate());
        order.setId(orderEntity.getId());
        order.setPayed(orderEntity.getPayed());

        return order;

        //return mapper.map(orderEntity, Order.class);
    }

    public OrderEntity orderModelToOrderEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderDate(order.getOrderDate());
        orderEntity.setId(order.getId());
        orderEntity.setPayed(order.getPayed());
        orderEntity.setUser(userModelToUserEntity(order.getUser()));

        return orderEntity;

        //return mapper.map(order, OrderEntity.class);
    }

    public Discount discountEntityToDiscountModel(DiscountEntity discountEntity){
        Discount discount = new Discount();
        discount.setDiscountVal(discountEntity.getDiscountVal());
        discount.setCategory(categoryEntityToCategoryModel(discountEntity.getCategory()));
        discount.setBeginDate(discountEntity.getBeginDate());
        discount.setEndDate(discountEntity.getEndDate());
        discount.setId(discountEntity.getId());

        return discount;

        //return mapper.map(discountEntity, Discount.class);
    }

    public DiscountEntity discountModelToDiscountEntity(Discount discount){
        DiscountEntity discountEntity = new DiscountEntity();
        discountEntity.setDiscountVal(discount.getDiscountVal());
        discountEntity.setCategory(categoryModelToCategoryEntity(discount.getCategory()));
        discountEntity.setId(discount.getId());
        discountEntity.setBeginDate(discount.getBeginDate());
        discountEntity.setEndDate(discount.getEndDate());

        return discountEntity;
        //return mapper.map(discount, DiscountEntity.class);
    }

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity){
        return mapper.map(categoryEntity, Category.class);
    }

    public CategoryEntity categoryModelToCategoryEntity(Category category){
        return mapper.map(category, CategoryEntity.class);
    }

    public Product productEntityToProductModel(ProductEntity productEntity){
        return mapper.map(productEntity, Product.class);
    }

    public ProductEntity productModelToProductEntity(Product product){
        return mapper.map(product, ProductEntity.class);
    }
}
