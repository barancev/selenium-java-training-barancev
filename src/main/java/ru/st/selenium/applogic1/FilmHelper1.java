package ru.st.selenium.applogic1;

import java.util.List;

import ru.st.selenium.applogic.FilmHelper;
import ru.st.selenium.model.Film;

public class FilmHelper1 extends DriverBasedHelper implements FilmHelper {

  public FilmHelper1(ApplicationManager1 manager) {
    super(manager.getWebDriver());
  }

  @Override
  public void create(Film film) {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(Film film) {
    // TODO Auto-generated method stub

  }

  @Override
  public List<Film> search(String title) {
    // TODO Auto-generated method stub
    return null;
  }

}
