
import controlador.ContactoController;
import controlador.ContactoControllerImpl;
import java.util.ArrayList;
import java.util.List;
import modelo.ContactoModel;
import modelo.ContactoModelImpl;
import vista.ContactoView;
import vista.ContactoViewImpl;





public class Main {


    
    public static void main(String[] args) {

        ContactoModel model = new ContactoModelImpl();

        ContactoView view1 = new ContactoViewImpl();
        ContactoView view2 = new ContactoViewImpl();
        List<ContactoView> views= new ArrayList<ContactoView>();
        views.add(view1);
        views.add(view2);

        ContactoController controller1 = new ContactoControllerImpl();
        
        controller1.setup(model, views);
        controller1.start();
    }

}
