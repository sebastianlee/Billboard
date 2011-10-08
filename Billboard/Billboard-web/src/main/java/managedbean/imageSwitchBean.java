package managedbean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.RequestScoped;

@ManagedBean(name = "imageSwitchBean")
@RequestScoped
public class imageSwitchBean {

    private List<String> images;

    public imageSwitchBean() {
        images = new ArrayList<String>();
        images.add("1.jpg");
        images.add("2.jpg");
        images.add("3.jpg");
        images.add("4.jpg");
        images.add("5.jpg");
        images.add("6.jpg");
        images.add("7.jpg");
        images.add("8.jpg");
        images.add("9.jpg");
        images.add("10.jpg");
        images.add("11.jpg");
        images.add("12.jpg");

    }

    public List<String> getImages() {
        return images;
    }
}
