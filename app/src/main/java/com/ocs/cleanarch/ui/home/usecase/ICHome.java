package com.ocs.cleanarch.ui.home.usecase;

import com.ocs.cleanarch.ui.base.IBasePresenter;
import com.ocs.cleanarch.ui.base.IBaseView;

/**
 * Created on 19/5/18.
 */

public interface ICHome {

    interface IVHome extends IBaseView {


    }

    interface IPHome<V extends IVHome> extends IBasePresenter<V> {

    }
}