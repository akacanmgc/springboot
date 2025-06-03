package com.akacan.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stok")
public class Stok {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "boş geçilemez")
    @Max(value = 59)
    @Min(value = 2)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
