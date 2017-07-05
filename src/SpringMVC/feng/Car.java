package SpringMVC.feng;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/29 0029.
 */
public class Car {


    public String name;
    public Integer lun;
    public  Company company;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birth;
    @NumberFormat(pattern="#,###,###.#")
    private Float salary;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLun() {
        return lun;
    }

    public void setLun(Integer lun) {
        this.lun = lun;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", lun=" + lun +
                ", company=" + company +
                '}';
    }

    public Car(Integer lun, String name) {
        this.lun = lun;
        this.name = name;
        this.company = company;
    }
    public  Car(){
        super();
    }
}
