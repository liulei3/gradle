package com.test;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class LibraryTest {
	private static final String TEST_SPEAKER = "age = 39\n" + "fullName = \"Larson Richard\"\n"
			+ "tags = [\"JavaScript\",\"AngularJS\",\"Yeoman\"]\n" + "registered = true";

	@Test
	public void serializeBasicTypes() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Writer writer = new StringWriter();
			int age = 39;
			String fullName = new String("Larson Richard");
			List<String> tags = new ArrayList<String>(Arrays.asList("JavaScript", "AngularJS", "Yeoman"));
			boolean registered = true;
			String speaker = null;
			writer.write("age = ");
			mapper.writeValue(writer, age);
			writer.write("\nfullName = ");
			mapper.writeValue(writer, fullName);
			writer.write("\ntags = ");
			mapper.writeValue(writer, tags);
			writer.write("\nregistered = ");
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			mapper.writeValue(writer, registered);
			speaker = writer.toString();
			System.out.println(speaker);
			assertTrue(TEST_SPEAKER.equals(speaker));
			assertTrue(true);
		} catch (JsonGenerationException jge) {
			jge.printStackTrace();
			fail(jge.getMessage());
		} catch (JsonMappingException jme) {
			jme.printStackTrace();
			fail(jme.getMessage());
		} catch (IOException ioe) {
			ioe.printStackTrace();
			fail(ioe.getMessage());
		}
	}

	@Test
	public void deSerializeBasicTypes() {
		try {
			String ageJson = "{ \"age\": 39 }";
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Integer> ageMap = mapper.readValue(ageJson, new TypeReference<HashMap<String, Integer>>() {
			});
			Integer age = ageMap.get("age");
			System.out.println("age = " + age + "\n\n\n");
			assertEquals(39, age.intValue());
			assertTrue(true);
		} catch (JsonMappingException jme) {
			jme.printStackTrace();
			fail(jme.getMessage());
		} catch (IOException ioe) {
			ioe.printStackTrace();
			fail(ioe.getMessage());
		}
	}
}
