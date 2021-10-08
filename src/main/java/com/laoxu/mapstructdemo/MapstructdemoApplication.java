package com.laoxu.mapstructdemo;

import com.laoxu.mapstructdemo.DO.Person;
import com.laoxu.mapstructdemo.DO.User;
import com.laoxu.mapstructdemo.convert.PersonConverter;
import com.laoxu.mapstructdemo.dto.PersonDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class MapstructdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapstructdemoApplication.class, args);
		Person person = new Person(1L,"zhige","zhige.me@gmail.com",new Date(),new User(1));
		PersonDTO personDTO = PersonConverter.INSTANCE.domain2dto(person);
		System.out.println(personDTO);
		System.out.println(Objects.equals(personDTO.getId(), person.getId()));
		System.out.println(Objects.equals(personDTO.getName(), person.getName()));
		System.out.println(Objects.equals(personDTO.getBirth(), person.getBirthday()));
		String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(personDTO.getBirth());
		System.out.println(Objects.equals(personDTO.getBirthDateFormat(),format));
		System.out.println(Objects.equals(personDTO.getBirthExpressionFormat(),format));

		List<Person> people = new ArrayList<>();
		people.add(person);
		List<PersonDTO> personDTOs = PersonConverter.INSTANCE.domain2dto(people);
		System.out.println(personDTOs);
	}

}
