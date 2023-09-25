import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter y setters
@AllArgsConstructor // crea un constructor con todos los argumentos
@NoArgsConstructor // crea un constructor vacio
public class Estudiante {
    private String nombre;
    private int edad;
}
