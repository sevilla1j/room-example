package com.christopher.elias.room.ui.destinations.fragments.todo.list

import android.view.View
import androidx.lifecycle.Observer
import com.christopher.elias.room.BR
import com.christopher.elias.room.R
import com.christopher.elias.room.databinding.FragmentTodoListBinding
import com.christopher.elias.room.model.TodoModel
import com.christopher.elias.room.ui.base.BaseFragment
import com.christopher.elias.room.ui.destinations.fragments.todo.detail.TodoDetailFragment

/**
 * Created by Christopher Elias on 3/02/2020.
 * christopher.mike.96@gmail.com
 *
 * Peru Apps
 * Lima, Peru.
 **/
class TodoListFragment : BaseFragment<FragmentTodoListBinding, TodoListViewModel>(TodoListViewModel::class), TodoListNavigator {

    override val getBindingVariable: Int
        get() = BR.todoListViewModel

    override val getLayoutId: Int
        get() = R.layout.fragment_todo_list

    override fun onFragmentViewReady(view: View) {
        myViewModel.setNavigator(this)
        myViewModel.todoList.observe(this, Observer {
            myViewModel.bindItemsAfterMapping(it)
        })
    }

    override fun onTodoObjectClicked(todo: TodoModel) {
        addFragment(R.id.frame_main, TodoDetailFragment.newInstance(todo), true)
    }
}