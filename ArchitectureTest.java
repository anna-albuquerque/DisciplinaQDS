package com.example;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

class ArchitectureTest {
    @Test
    void servicesShouldOnlyBeAccessedByApplicationLayer() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.example");

        ArchRuleDefinition.classes()
                .that().resideInAPackage("..service..")
                .should().onlyBeAccessed().byClassesThat().resideInAPackage("..com.example");
    }
}
