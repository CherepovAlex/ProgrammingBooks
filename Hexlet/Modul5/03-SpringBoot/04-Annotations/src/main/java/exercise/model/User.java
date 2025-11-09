package exercise.model;

import exercise.interfaces.UserDetails;

public class User implements UserDetails {

    // помеченный метод должен переопределять метод наследуемого класса или реализовывать метод интерфейса
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setFirstName(Object firstName) {
    }

    public void setEmail(Object email) {
    }

    public Object getFirstName() {
        return new Object();
    }

    public String getEmail() {
        return "e-mail";
    }
}
