package Observer;
// import Observable.Subject;
public class PhoneDisplay implements DisplayObserver {
    private String weather;
    @Override
    public void update(String weather) {
        this.weather = weather;
        display();
    }
    private void display() {
        System.out.println("Phone Display: Weather updated - " + weather);
    }
}

