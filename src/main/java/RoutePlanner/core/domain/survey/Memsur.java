package RoutePlanner.core.domain.survey;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class Memsur {

    private Long id;

    @NotBlank(message = "첫번째 질문을 선택해주세요.")
    private String userWhere;

    @NotBlank(message = "두번째 질문을 선택해주세요.")
    private String userWHAT;

    @NotBlank(message = "세번째 질문을 선택해주세요.")
    private String userWho;
}

