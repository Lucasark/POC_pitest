package poc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class POCTest {
    @InjectMocks
    private POC poc;

    @Test
    void exception() {
        var newName = "NAME";

        POC_Class father = POC_Class.builder()
                .build();

        POC_Children_Class child = POC_Children_Class.builder()
                .id(1L)
                .name("NAME")
                .build();

        father.getListChildren().add(child);

        assertThatCode(() -> poc.method(father, 1L, newName))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("SAME NAME");
    }

    @Test
    void testChangeValue() {
        var newName = "NEWNAME";

        POC_Class father = POC_Class.builder()
                .name("NAME")
                .build();

        POC_Children_Class child = POC_Children_Class.builder()
                .id(1L)
                .name("NAME")
                .build();

        father.getListChildren().add(child);

        assertThatCode(() -> poc.method(father, 2L, newName))
                .doesNotThrowAnyException();

        assertEquals("NEWNAME", father.getName());
    }
}
