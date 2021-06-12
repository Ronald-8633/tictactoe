package com.sensedia.tictac.domain.model;

import com.sensedia.tictac.domain.model.enums.Mark;
import com.sensedia.tictac.exception.exceptions.UnProcessableEntityException;
import com.sensedia.tictac.exception.model.InvalidDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Game {
    @Null
    String id;

    String turn;
    String mark;
    List<String> board;

    public void validGame() {
        List<InvalidDetailDTO> invalidDetailDTOS = new ArrayList<>();
        if (Objects.isNull(mark))
            invalidDetailDTOS.add(InvalidDetailDTO
                    .builder()
                    .property("mark")
                    .descriptionError("Mark can't be null")
                    .build());

        else if (!Mark.contains(mark))
            invalidDetailDTOS.add(InvalidDetailDTO
                    .builder()
                    .property("mark")
                    .descriptionError("Value must be X or Y")
                    .build());

        if (Objects.isNull(turn))
            invalidDetailDTOS.add(InvalidDetailDTO
                    .builder()
                    .property("turn")
                    .descriptionError("Turn can't be null")
                    .build());


        if (!invalidDetailDTOS.isEmpty())
            throw new UnProcessableEntityException(invalidDetailDTOS);
    }
}
