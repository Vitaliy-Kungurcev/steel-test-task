package testtask.steel.entity;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name = "supply")
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    @NotEmpty(message = "Поле не может быть пустым")
    private String name;

    @Column(name = "provider")
    private String provider;

    @Column(name = "weight")
    @Min(value = 1,message = "Диапозон массы должен быть от 1 до 100000")
    @Max(value = 100000,message = "Диапозон массы должен быть от 1 до 100000")
    private int weight;

    @Column(name = "price")
    @Min(value = 1,message = "Диапозон цены должен быть от 1 до 100000")
    @Max(value = 100000,message = "Диапозон цены должен быть от 1 до 100000")
    private int price;

    @Column(name = "date")
    private LocalDate date;

    @Column
    private int sum_weight;

    @Column
    private int sum_price;

    @Column
    private int count;

    public Supply() {
    }

    public Supply(String type, String name, String provider, int weight, int price) {
        this.type = type;
        this.name = name;
        this.provider = provider;
        this.weight = weight;
        this.price = price;
    }


    public Supply(String type, String name, String provider, int weight, int price, int sum_weight, int sum_price,int count) {
        this.type = type;
        this.name = name;
        this.provider = provider;
        this.weight = weight;
        this.price = price;
        this.sum_weight = sum_weight;
        this.sum_price = sum_price;
        this. count=count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getSum_weight() {
        return sum_weight;
    }

    public void setSum_weight(int sum_weight) {
        this.sum_weight = sum_weight;
    }

    public int getSum_price() {
        return sum_price;
    }

    public void setSum_price(int sum_price) {
        this.sum_price = sum_price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}



