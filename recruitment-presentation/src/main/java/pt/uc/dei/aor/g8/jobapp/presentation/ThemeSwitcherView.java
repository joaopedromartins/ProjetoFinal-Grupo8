package pt.uc.dei.aor.g8.jobapp.presentation;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import pt.uc.dei.aor.g8.jobapp.presentation.Theme;
import pt.uc.dei.aor.g8.jobapp.presentation.ThemeService;
 
@ManagedBean
public class ThemeSwitcherView {
 
    private List<Theme> themes;
     
    @ManagedProperty("#{themeService}")
    private ThemeService service;
 
    @PostConstruct
    public void init() {
        themes = service.getThemes();
    }
     
    public List<Theme> getThemes() {
        return themes;
    } 
 
    public void setService(ThemeService service) {
        this.service = service;
    }

}
