package com.spring.TecSUS.controle;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.spring.TecSUS.modelo.Conta;
import com.spring.TecSUS.repositorio.ContaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContaControle {
    @RequestMapping(value = "/energias/conta/novo", method = RequestMethod.GET)
    public String getContaForm(){
        return "contaForm";
    }
}
