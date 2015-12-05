package com.bug.model;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "bug")
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int bugId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "creation_date", nullable = false)
    @Type(type = "com.bug.model.LocalDateHibernateUserType")
    private LocalDate creationDate;

    @Column(name = "due_date")
    @Type(type = "com.bug.model.LocalDateHibernateUserType")
    private LocalDate dueDate;

    public Bug() {
    }

    public Bug(String name, String description, LocalDate creationDate, LocalDate dueDate) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
    }

    public int getBugId() {
        return bugId;
    }

    public void setBugId(int bugId) {
        this.bugId = bugId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bug)) return false;

        Bug bug = (Bug) o;

        if (bugId != bug.bugId) return false;
        if (!creationDate.equals(bug.creationDate)) return false;
        if (!description.equals(bug.description)) return false;
        if (dueDate != null ? !dueDate.equals(bug.dueDate) : bug.dueDate != null) return false;
        if (!name.equals(bug.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bugId;
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + creationDate.hashCode();
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        return result;
    }
}
