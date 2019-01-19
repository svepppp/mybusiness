package ex1.mb.service;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTable {
    private JdbcTemplate jdbcTemplate;
    public CreateTable() {
    }

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getTableCreationStatus() {
      try {
          /*  jdbcTemplate.execute("DROP TABLE IF EXISTS dogs");


            jdbcTemplate.execute("CREATE TABLE public.dogs\n" +
                    "(\n" +
                    "    id integer NOT NULL,\n" +
                    "    name character varying(255) COLLATE pg_catalog.\"default\",\n" +
                    "    description character varying(255) COLLATE pg_catalog.\"default\",\n" +
                    "    color_id integer,\n" +
                    "    CONSTRAINT dogs_pkey PRIMARY KEY (id)\n" +
                    ")");
*/


    //        jdbcTemplate.execute("select b.name from bees c where c.color_id=(select id from colors cl where cl.name='grey')");
            return "table created and request completed";
        } catch (Exception e) {
            return "Table creation failed " + e;
        }
    }
}

