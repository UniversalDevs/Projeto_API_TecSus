package com.spring.TecSUS;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import javax.persistence.EntityManager;

import com.spring.TecSUS.modelo.Conta;
import com.spring.TecSUS.repositorio.ContaRepositorio;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import ch.qos.logback.core.util.FileSize;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TecSusApplicationTests {

	@Autowired
	private ContaRepositorio repo;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	@Rollback(false)
	void testInsertConta() throws IOException {
		File file = new File("C:\\Users\\Felipe\\Documents\\Curriculo.pdf");
		Conta conta = new Conta();
		conta.setName(file.getName());

		byte[] bytes = Files.readAllBytes(file.toPath()); 
		conta.setContent(bytes);
		long contaSize = bytes.length; 
		conta.setSize(contaSize);
		conta.setUploadTime(Date.valueOf(LocalDate.now(ZoneId.of("UTC"))));

		Conta savedConta = repo.save(conta);

		Conta existConta = entityManager.find(Conta.class, savedConta.getConta_id());

		assertThat(existConta.getSize()).isEqualTo(contaSize);
	}

}
