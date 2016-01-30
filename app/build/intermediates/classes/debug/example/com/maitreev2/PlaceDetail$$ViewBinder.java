// Generated code from Butter Knife. Do not modify!
package example.com.maitreev2;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class PlaceDetail$$ViewBinder<T extends example.com.maitreev2.PlaceDetail> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624117, "field 'placename'");
    target.placename = finder.castView(view, 2131624117, "field 'placename'");
    view = finder.findRequiredView(source, 2131624120, "field 'basedesc'");
    target.basedesc = finder.castView(view, 2131624120, "field 'basedesc'");
    view = finder.findRequiredView(source, 2131624123, "field 'extradesc'");
    target.extradesc = finder.castView(view, 2131624123, "field 'extradesc'");
    view = finder.findRequiredView(source, 2131624119, "field 'coordinatorname'");
    target.coordinatorname = finder.castView(view, 2131624119, "field 'coordinatorname'");
    view = finder.findRequiredView(source, 2131624116, "field 'placeicon'");
    target.placeicon = finder.castView(view, 2131624116, "field 'placeicon'");
  }

  @Override public void unbind(T target) {
    target.placename = null;
    target.basedesc = null;
    target.extradesc = null;
    target.coordinatorname = null;
    target.placeicon = null;
  }
}
