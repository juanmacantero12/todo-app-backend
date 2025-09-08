package com.example.todo_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// La anotación @Entity le dice a Spring que esta clase representa una tabla en la base de datos.
@Entity
// @Table especifica que el nombre de la tabla en la base de datos será "tasks".
@Table(name = "tasks")
public class Task {

    // @Id indica que este campo es la clave primaria (el identificador único).
    // @GeneratedValue le dice a la base de datos que genere este valor automáticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private boolean isCompleted;

    // Se necesita un constructor vacío para que Hibernate/JPA funcione correctamente.
    public Task() {
    }

    // Getters y Setters: Son métodos que permiten a otras partes del código
    // leer y modificar de forma segura las propiedades de esta clase.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}