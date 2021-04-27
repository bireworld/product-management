package labs.pm.data;

import java.math.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Product implements Rateable<Product>{
    public static final BigDecimal DISCOUNT_RATE=BigDecimal.valueOf(0.1);
    private final int id;
    private final String name;
    private final BigDecimal price;
    private final Rating rating;

//     Product(){
//        this(0,"no name",BigDecimal.ZERO);
//    }
     public Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
//    public Product(int id, String name, BigDecimal price) {
//    this(id, name, price, Rating.NOT_RATED);
//    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getDiscount() {
        return price.multiply(DISCOUNT_RATE).setScale(2,RoundingMode.HALF_UP);
    }
    @Override
    public Rating getRating() {
        return rating;
    }
    //public abstract Product applyRating(Rating newRating);
//    {
//        return new Product(this.id,this.name,this.price,newRating);
//
//    }
    public LocalDate getBestBefore(){
        return LocalDate.now();
    }

    @Override
    public String toString() {
        return id+", "+name+", "+price+", "+getDiscount()+", "+rating.getStars()+", "+getBestBefore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
