package com.cremy.firebucket.domain.interactors.user;

import com.cremy.firebucket.data.repositories.UserRepository;
import com.cremy.firebucket.domain.interactors.Params;
import com.cremy.firebucket.domain.interactors.base.BaseUseCase;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Implementation of {@link BaseUseCase} that represents a UseCase/Interactor
 */
public class LoginUserUseCase extends BaseUseCase {

  private final UserRepository userRepository;

  public final static String PARAMS_KEY_EMAIL = "param_email";
  public final static String PARAMS_KEY_PASSWORD = "param_password";

  @Inject
  public LoginUserUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override public Observable getObservable(Params params) {
    return this.userRepository.login(params.getString(PARAMS_KEY_EMAIL, null),
            params.getString(PARAMS_KEY_PASSWORD, null));
  }
}