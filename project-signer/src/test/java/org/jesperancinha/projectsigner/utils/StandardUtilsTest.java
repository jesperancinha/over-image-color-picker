package org.jesperancinha.projectsigner.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StandardUtilsTest {

    @Test
    void testSanitizeTag() {
        final String result = StandardUtils.sanitizeTag("### Title1 ##");
        assertThat(result).isEqualTo("Title1 ##");
    }

    @Test
    void testSanitizeTagAllHashes() {
        final String result = StandardUtils.sanitizeTag("#####");
        assertThat(result).isEmpty();
    }

    @Test
    void testCounHashTags() {
        final int result = StandardUtils.counHashTags("### okoko #");
        assertThat(result).isEqualTo(3);
    }
}