import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. Configure Freemarker
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
            cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            cfg.setWrapUncheckedExceptions(true);

            // 2. Mock Employee Data (simulate localStorage-style JSON)
            List<Map<String, String>> employees = new ArrayList<>();

            employees.add(Map.of(
                    "id", UUID.randomUUID().toString(),
                    "firstName", "Jyoti",
                    "lastName", "Swain",
                    "email", "jyoti@example.com",
                    "department", "Engineering",
                    "role", "Frontend Developer"
            ));

            employees.add(Map.of(
                    "id", UUID.randomUUID().toString(),
                    "firstName", "Rahul",
                    "lastName", "Verma",
                    "email", "rahul@example.com",
                    "department", "Sales",
                    "role", "Manager"
            ));

            employees.add(Map.of(
                    "id", UUID.randomUUID().toString(),
                    "firstName", "Anita",
                    "lastName", "Patel",
                    "email", "anita@example.com",
                    "department", "HR",
                    "role", "Recruiter"
            ));

            // 3. Data Model for index.ftl
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("employees", employees);

            // 4. Render index.ftl → output/index.html
            Template indexTemplate = cfg.getTemplate("index.ftl");
            File outputDir = new File("output");
            if (!outputDir.exists()) outputDir.mkdir();

            try (Writer out = new FileWriter("output/index.html")) {
                indexTemplate.process(dataModel, out);
                System.out.println("✅ index.html generated successfully in /output folder!");
            }

            // 5. Render form.ftl → output/form.html (no data required)
            Template formTemplate = cfg.getTemplate("form.ftl");
            try (Writer out = new FileWriter("output/form.html")) {
                formTemplate.process(new HashMap<>(), out);
                System.out.println("✅ form.html generated successfully in /output folder!");
            }

        } catch (Exception e) {
            System.err.println("❌ Error generating templates: " + e.getMessage());
            e.printStackTrace();
        }
    }
}