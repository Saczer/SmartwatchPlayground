package pl.olszak.michal.smartwatchplayground.rx

import io.reactivex.Scheduler

/**
 * @author molszak
 *         created on 09.11.2017.
 */
interface PlaygroundSchedulers {

    fun computation() : Scheduler

    fun ui() : Scheduler

    fun io() : Scheduler

}