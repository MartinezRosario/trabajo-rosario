package ar.edu.unju.edm.app.config.error;

import ar.edu.unju.edm.app.domain.util.constants.ViewKeys;
import ar.edu.unju.edm.app.domain.util.constants.ViewNames;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception exception) {
        // model.addAttribute("errorMessage", "Ocurrió un error inesperado");
        return new ModelAndView(ViewNames.ERROR)
                .addObject(ViewKeys.ERROR_CODE, exception);
    }

}