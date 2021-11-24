package com.example.universitytesttask.model;

import java.util.List;
import com.example.universitytesttask.meta.Degree;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "lectors")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private Degree degree;
    private String name;
    private Double salary;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Department> departments;
}
