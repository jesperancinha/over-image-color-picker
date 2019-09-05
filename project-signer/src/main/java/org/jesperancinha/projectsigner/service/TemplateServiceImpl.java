package org.jesperancinha.projectsigner.service;

import static  org.jesperancinha.parser.TemplateParser.findAllParagraphs;

import org.jesperancinha.parser.TemplateParser;
import org.jesperancinha.parser.model.Paragraphs;
import org.jesperancinha.projectsigner.inteface.TemplateService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * A markdown template service to handle markdown texts
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    /**
     * Receives an input markdown text stream nd parses its content to a Paragraphs object see {@link Paragraphs}
     *
     * @param templateInputStream An input markdown text stream
     * @return A {@link Paragraphs} parsed object
     * @throws IOException Any kind of IO Exception
     */
    @Override
    public Paragraphs findAllParagraphs(final InputStream templateInputStream) throws IOException {
        return TemplateParser.findAllParagraphs(templateInputStream);
    }


}
