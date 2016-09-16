package tellh.com.gitclub.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import tellh.com.gitclub.di.Fragment;
import tellh.com.gitclub.model.net.DataSource.ExploreDataSource;
import tellh.com.gitclub.model.net.DataSource.RepositoryDataSource;
import tellh.com.gitclub.model.net.DataSource.UserDataSource;
import tellh.com.gitclub.presentation.contract.ExploreContract;
import tellh.com.gitclub.presentation.contract.LoginContract;
import tellh.com.gitclub.presentation.contract.NewsContract;
import tellh.com.gitclub.presentation.contract.SearchContract;
import tellh.com.gitclub.presentation.presenter.ExplorePresenter;
import tellh.com.gitclub.presentation.presenter.PersonalPagePresenter;
import tellh.com.gitclub.presentation.presenter.ListRepoPresenter;
import tellh.com.gitclub.presentation.presenter.ListUserPresenter;
import tellh.com.gitclub.presentation.presenter.LoginPresenter;
import tellh.com.gitclub.presentation.presenter.NewsPresenter;
import tellh.com.gitclub.presentation.presenter.SearchPresenter;
import tellh.com.gitclub.presentation.contract.PersonalPageContract.Presenter;

@Module
public class PresenterModule {
    @Provides
    public LoginContract.Presenter provideLoginPresenter(UserDataSource dataSource) {
        return new LoginPresenter(dataSource);
    }

    @Provides
    @Fragment
    public SearchContract.Presenter provideSearchPresenter(RepositoryDataSource repositoryDataSource, UserDataSource userDataSource) {
        return new SearchPresenter(repositoryDataSource, userDataSource);
    }

    @Provides
    @Fragment
    public ExploreContract.Presenter provideExplorePresenter(ExploreDataSource exploreDataSource, RepositoryDataSource repositoryDataSource) {
        return new ExplorePresenter(exploreDataSource, repositoryDataSource);
    }

    @Provides
    public NewsContract.Presenter provideNewsPresenter(UserDataSource userDataSource, Context context) {
        return new NewsPresenter(userDataSource, context);
    }

    @Provides
    public Presenter provideHomePagePresenter(RepositoryDataSource repositoryDataSource, UserDataSource userDataSource, Context ctx) {
        return new PersonalPagePresenter(repositoryDataSource, userDataSource, ctx);
    }

    @Provides
    public ListRepoPresenter provideListRepoPresenter(UserDataSource userDataSource, RepositoryDataSource repositoryDataSource) {
        return new ListRepoPresenter(userDataSource, repositoryDataSource);
    }

    @Provides
    public ListUserPresenter provideListUserPresenter(RepositoryDataSource repositoryDataSource, UserDataSource userDataSource) {
        return new ListUserPresenter(repositoryDataSource, userDataSource);
    }
}