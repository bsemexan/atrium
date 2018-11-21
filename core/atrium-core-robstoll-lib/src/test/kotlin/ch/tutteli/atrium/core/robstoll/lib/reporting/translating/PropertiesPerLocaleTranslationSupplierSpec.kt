package ch.tutteli.atrium.core.robstoll.lib.reporting.translating

import ch.tutteli.atrium.verbs.internal.AssertionVerbFactory
import ch.tutteli.atrium.domain.builders.reporting.reporterBuilder
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.include

object PropertiesPerLocaleTranslationSupplierSpec : Spek({
    include(AtriumsTranslationSupplierSpec)
    include(AtriumsTranslationIntSpec)
}) {

    object AtriumsTranslationSupplierSpec : ch.tutteli.atrium.spec.reporting.translating.TranslationSupplierSpec(
        AssertionVerbFactory, ::PropertiesPerLocaleTranslationSupplier, "[Atrium's TranslationSupplierSpec] ")

    object AtriumsTranslationIntSpec : ch.tutteli.atrium.spec.reporting.translating.TranslatorIntSpec(
        AssertionVerbFactory,
        { primaryLocale, fallbackLocales ->
            reporterBuilder
                .withTranslationSupplier(PropertiesPerLocaleTranslationSupplier())
                .withDefaultLocaleOrderDecider()
                .withDefaultTranslator(primaryLocale, *fallbackLocales)
                .withDetailedObjectFormatter()
                .withDefaultAssertionFormatterController()
                .withDefaultAssertionFormatterFacade()
                .withTextSameLineAssertionPairFormatter()
                .withDefaultTextCapabilities()
                .withOnlyFailureReporter()
                .build()
        },
        true,
        "[Atrium's TranslationIntSpec] "
    )
}