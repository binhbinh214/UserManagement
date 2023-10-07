
import controller.UserManagement;
import model.Model;
import view.Menu;

public class MainSystem {
    public static void main(String[] args) {
        Model model = new Model();
        Menu view = new Menu();
        UserManagement controller = new UserManagement(model, view);
        controller.run();
    }
}
