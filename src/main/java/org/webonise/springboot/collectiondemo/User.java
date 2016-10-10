package org.webonise.springboot.collectiondemo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User implements Comparable<User> {
    private String id;
    private String name;
    private String DOB;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int compareTo(User user2) {
        return getName().compareTo(user2.getName());
    }

    @Override
    public boolean equals(Object o) {

        User user = (User) o;

        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(getId(), user.getId());
        equalsBuilder.append(getName(), user.getName());
        equalsBuilder.append(getDOB(), user.getDOB());
        equalsBuilder.append(getEmail(), user.getEmail());

        return equalsBuilder.isEquals();
    }

    @Override
    public int hashCode() {

        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(getId());
        builder.append(getName());
        builder.append(getDOB());
        builder.append(getEmail());

        return builder.toHashCode();
    }
}

