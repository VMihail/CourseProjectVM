package com.example.courseprojectvm;

import org.springframework.test.context.jdbc.Sql;

@Sql(value = "classpath:sql/cleanDB.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class BaseTest {
}