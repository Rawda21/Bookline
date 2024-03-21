package com.example.bookline.domain.usecase

//import com.example.bookline.domain.repo.AppPreferencesRepository
import javax.inject.Inject

//interface FinishOnboardingUseCase {
//    suspend operator fun invoke(): Result<Unit>
//}
//
//class FinishOnboardingUseCaseImpl @Inject constructor(
//    private val preferencesRepository: AppPreferencesRepository
//) : FinishOnboardingUseCase {
//    override suspend fun invoke(): Result<Unit> {
//        return try {
//            preferencesRepository.updateShowOnboarding(false)
//            Result.Success(Unit)
//        } catch (e: Throwable) {
//            Result.Error(e)
//        }
//    }
//}