package com.spring.henallux.springProject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesConfiguration {
    // to configure tiles with the tiles.xml
    // the usage of tiles is useful to define page fragments to reduce
    // duplication and develop reusable templates
    @Bean
    public TilesConfigurer tilesConfigurer() {
        final TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions("WEB-INF/resources/tiles.xml");
        configurer.setCheckRefresh(true);
        return configurer;
    }

    // to configure the ViewResolver with TilesView class
    // the resolver will resolve a logical view name (returned by a controller)
    // to the Tile definition configured in the tiles.xml
    @Bean
    public ViewResolver tilesViewResolver () {
        final TilesViewResolver resolver = new TilesViewResolver();
        resolver.setViewClass(TilesView.class);
        return resolver;
    }
}