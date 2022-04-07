package poc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class POC_Class {

    public String name;

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    public Set<POC_Children_Class> listChildren = new HashSet<>();
}
