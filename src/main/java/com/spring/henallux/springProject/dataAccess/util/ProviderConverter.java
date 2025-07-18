package com.spring.henallux.springProject.dataAccess.util;

import com.spring.henallux.springProject.dataAccess.entity.*;
import com.spring.henallux.springProject.dataAccess.entity.LanguageEntity;
import com.spring.henallux.springProject.model.*;
import org.dozer.DozerBeanMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

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
        Translation translation = new Translation();
        translation.setId(translationEntity.getId());
        translation.setCategory(categoryEntityToCategoryModel(translationEntity.getCategory()));
        translation.setDescription(translationEntity.getDescription());
        translation.setName(translationEntity.getName());
        translation.setLanguage(languageEntityToLanguageModel(translationEntity.getLanguage()));

        return translation;
    }

    public TranslationEntity translationModelToTranslationEntity(Translation translation) {
        TranslationEntity translationEntity = new TranslationEntity();
        translationEntity.setCategory(categoryModelToCategoryEntity(translation.getCategory()));
        translationEntity.setId(translation.getId());
        translationEntity.setDescription(translation.getDescription());
        translationEntity.setName(translation.getName());
        translationEntity.setLanguage(languageModelToLanguageEntity(translation.getLanguage()));

        return translationEntity;
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
    }

    public OrderLineEntity orderLineModelToOrderLineEntity(OrderLine orderLine) {
        OrderLineEntity orderLineEntity = new OrderLineEntity();
        orderLineEntity.setOrder(orderModelToOrderEntity(orderLine.getOrder()));
        orderLineEntity.setId(orderLine.getId());
        orderLineEntity.setDiscount(orderLine.getDiscount());
        orderLineEntity.setProduct(productModelToProductEntity(orderLine.getProduct()));
        orderLineEntity.setPrice(orderLine.getPrice());
        orderLineEntity.setQuantity(orderLine.getQuantity());

        return orderLineEntity;
    }

    public Order orderEntityToOrderModel(OrderEntity orderEntity) {
        Order order = new Order();
        order.setUser(userEntityToUserModel(orderEntity.getUser()));
        order.setOrderDate(orderEntity.getOrderDate());
        order.setId(orderEntity.getId());
        order.setIsPayed(orderEntity.getPayed());

        return order;
    }

    public OrderEntity orderModelToOrderEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderDate(order.getOrderDate());
        orderEntity.setId(order.getId());
        orderEntity.setPayed(order.getIsPayed());
        orderEntity.setUser(userModelToUserEntity(order.getUser()));

        return orderEntity;
    }

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity){
        Category category = new Category();
        category.setId(categoryEntity.getId());
        category.setDiscounts(categoryEntity.getDiscounts().stream().map(discountEntity -> discountEntityToDiscountModel(discountEntity)).toList());

        return category;
    }

    public CategoryEntity categoryModelToCategoryEntity(Category category){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setDiscounts(category.getDiscounts().stream().map(discount -> discountModelToDiscountEntity(discount)).toList());
        categoryEntity.setId(category.getId());

        return categoryEntity;
    }

    public Product productEntityToProductModel(ProductEntity productEntity){
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setDescription(productEntity.getDescription());
        product.setName(productEntity.getName());
        product.setCategory(categoryEntityToCategoryModel(productEntity.getCategory()));
        product.setPrice(productEntity.getPrice());

        return product;
    }

    public ProductEntity productModelToProductEntity(Product product){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setDescription(product.getDescription());
        productEntity.setName(product.getName());
        productEntity.setCategory(categoryModelToCategoryEntity(product.getCategory()));
        productEntity.setPrice(product.getPrice());

        return productEntity;
    }

    public Discount discountEntityToDiscountModel(DiscountEntity discountEntity){
        Discount discount = new Discount();
        discount.setDiscountVal(discountEntity.getDiscountVal());
        discount.setBeginDate(discountEntity.getBeginDate());
        discount.setEndDate(discountEntity.getEndDate());
        discount.setId(discountEntity.getId());

        return discount;
    }

    public DiscountEntity discountModelToDiscountEntity(Discount discount){
        DiscountEntity discountEntity = new DiscountEntity();
        discountEntity.setDiscountVal(discount.getDiscountVal());
        discountEntity.setId(discount.getId());
        discountEntity.setBeginDate(discount.getBeginDate());
        discountEntity.setEndDate(discount.getEndDate());

        return discountEntity;
    }
}
