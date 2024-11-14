package laTierraDeLaFantasia;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PuebloTest {
    
    private Pueblo pueblo;

    @BeforeEach
    void setUp() {
        // Inicializamos un pueblo con datos válidos
        pueblo = new Pueblo(1, 100, Raza.nortaichian, TipoPueblo.propio);
    }

    @Test
    void testConstructorValido() {
        // Comprobamos que el pueblo fue creado correctamente
        assertNotNull(pueblo);
        assertEquals(1, pueblo.getId());
        assertEquals(100, pueblo.getHabitantes());
        assertEquals(Raza.nortaichian, pueblo.getRaza());
        assertEquals(TipoPueblo.propio, pueblo.getTipo());
    }

    @Test
    void testConstructorHabitantesNegativos() {
        // Comprobamos que se lanza una excepción al intentar crear un pueblo con habitantes negativos
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Pueblo(2, -10, Raza.reralopes, TipoPueblo.aliado);
        });
        
        // Verificamos el mensaje de la excepción
        assertEquals("El número de habitantes no puede ser negativo", exception.getMessage());
    }

    @Test
    void testGetId() {
        // Verificamos que el id se obtiene correctamente
        assertEquals(1, pueblo.getId());
    }

    @Test
    void testGetHabitantes() {
        // Verificamos que el número de habitantes es correcto
        assertEquals(100, pueblo.getHabitantes());
    }

    @Test
    void testGetRaza() {
        // Verificamos que la raza es correcta
        assertEquals(Raza.nortaichian, pueblo.getRaza());
    }

    @Test
    void testGetTipo() {
        // Verificamos que el tipo de pueblo es correcto
        assertEquals(TipoPueblo.propio, pueblo.getTipo());
    }

    @Test
    void testToString() {
        // Verificamos que el método toString retorna el formato esperado
        String expected = "1 100 nortaichian propio";
        assertEquals(expected, pueblo.toString());
    }
}