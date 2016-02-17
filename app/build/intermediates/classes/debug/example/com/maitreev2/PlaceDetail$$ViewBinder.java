// Generated code from Butter Knife. Do not modify!
package example.com.maitreev2;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class PlaceDetail$$ViewBinder<T extends example.com.maitreev2.PlaceDetail> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131689680, "field 'placename'");
    target.placename = finder.castView(view, 2131689680, "field 'placename'");
    view = finder.findRequiredView(source, 2131689683, "field 'basedesc'");
    target.basedesc = finder.castView(view, 2131689683, "field 'basedesc'");
    view = finder.findRequiredView(source, 2131689686, "field 'extradesc'");
    target.extradesc = finder.castView(view, 2131689686, "field 'extradesc'");
    view = finder.findRequiredView(source, 2131689682, "field 'coordinatorname'");
    target.coordinatorname = finder.castView(view, 2131689682, "field 'coordinatorname'");
    view = finder.findRequiredView(source, 2131689679, "field 'placeicon'");
    target.placeicon = finder.castView(view, 2131689679, "field 'placeicon'");
    view = finder.findRequiredView(source, 2131689677, "field 'progressBar'");
    target.progressBar = finder.castView(view, 2131689677, "field 'progressBar'");
    view = finder.findRequiredView(source, 2131689678, "field 'relativeLayout'");
    target.relativeLayout = finder.castView(view, 2131689678, "field 'relativeLayout'");
    view = finder.findRequiredView(source, 2131689684, "field 'mDemoSlider'");
    target.mDemoSlider = finder.castView(view, 2131689684, "field 'mDemoSlider'");
  }

  @Override public void unbind(T target) {
    target.placename = null;
    target.basedesc = null;
    target.extradesc = null;
    target.coordinatorname = null;
    target.placeicon = null;
    target.progressBar = null;
    target.relativeLayout = null;
    target.mDemoSlider = null;
  }
}
