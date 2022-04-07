package poc;

import java.util.Objects;

public class POC {

    public void method(POC_Class dto, Long oldId, String newName) {
        dto.getListChildren().stream()
                .filter(children -> children.getId().equals(oldId))
                .forEach(children -> {
                    if (Objects.equals(children.getName(), newName)) {
                        throw new RuntimeException("SAME NAME");
                    }
                });

        dto.setName(newName);
    }
}
