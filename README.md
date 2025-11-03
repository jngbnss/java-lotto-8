# Lotto 게임 기능 및 구현 흐름

## 1️⃣ 구입 금액 입력

### 절차
1. 사용자에게 구입 금액 입력 요청
2. 입력값 공백 체크 (`InputHandler.emptyCheck`)
3. 문자열 → 정수 변환 (`PurchaseAmount` 도메인)
4. 값 검증 (`PurchaseAmountValidator`)
   - 1,000원 단위인지
   - 음수 또는 숫자 외 입력 체크

### 예외 처리
- 숫자가 아닌 경우 → `IllegalArgumentException`
- 1,000원 단위가 아닌 경우 → `IllegalArgumentException`
- 공백 입력 → `IllegalArgumentException`

### MVC/SRP
- **Controller**: 입력 흐름 관리
- **Domain**: `PurchaseAmount`에서 검증
- **View**: 사용자 입력 안내 및 출력

### 테스트
- 정상 입력, 음수, 문자 입력, 공백 테스트 완료

---

## 2️⃣ 구매 가능한 로또 개수 계산

### 절차
1. 구입 금액 / 1,000 → 구매 가능한 로또 개수 계산
2. 랜덤 로또 번호 생성 (`GenerateLottoNumbers`)
   - 1~45 중복 없는 번호 6개
   - 오름차순 정렬
3. 구매한 로또 번호 출력 (`OutputView.showLotteries`)

### MVC/SRP
- **Domain**: 로또 번호 생성 및 검증
- **View**: 로또 번호 출력
- **Controller**: 흐름 관리

### 테스트
- 번호 중복 없음, 정렬 확인 완료

---

## 3️⃣ 당첨 번호 입력

### 절차
1. 사용자에게 당첨 번호 입력 요청
2. 입력값 공백 체크
3. 문자열 → 로또 번호 변환 (`Converter.lottoConverter`)
4. 값 검증 (`Lotto` 클래스)
   - 1~45 범위
   - 중복 없는 6개 숫자

### 예외 처리
- 범위 벗어난 숫자 → `IllegalArgumentException`
- 중복 번호 입력 → `IllegalArgumentException`
- 공백/문자 입력 → `IllegalArgumentException`

### MVC/SRP
- **Domain**: 로또 번호 검증 (`Lotto`)
- **View**: 입력 안내
- **Controller**: 입력 처리 흐름

### 테스트
- 정상 입력, 중복, 범위 벗어난 번호 테스트 완료

---

## 4️⃣ 보너스 번호 입력

### 절차
1. 사용자에게 보너스 번호 입력 요청
2. 입력값 공백 체크
3. 문자열 → 정수 변환 (`Converter.intConverter`)
4. 값 검증 (`WinningLotto.validateBonusNumberNotDuplicate`)
   - 1~45 범위
   - 당첨 번호와 중복 체크

### 예외 처리
- 범위 벗어난 번호 → `IllegalArgumentException`
- 당첨 번호와 중복 → `IllegalArgumentException`

### MVC/SRP
- **Domain**: `WinningLotto`에서 검증
- **View**: 입력 안내
- **Controller**: 흐름 관리

### 테스트
- 정상 입력, 중복, 범위 벗어난 번호 테스트 완료

---

## 5️⃣ 당첨 통계 계산

### 절차
1. 로또 체커 생성 (`LottoChecker`)
   - 당첨 번호 + 보너스 번호 전달
2. 로또 결과 계산 (`LottoResultService.calculateResult`)
   - 구매한 로또 각각 비교
   - 등수 판정 (`Rank.valueOf(matchCount, bonusMatch)`)
   - `LottoResult.addResult` 호출
3. DTO 변환 (`LottoResultService.toDtoList`)
   - 수익률 포함
4. 결과 출력 (`OutputView.printStatics`)
   - 등수별 일치 개수, 보너스 여부, 상금, 당첨 개수

### MVC/SRP
- **Domain**: `LottoChecker`, `LottoResult`
- **Service**: `LottoResultService` → DTO 변환
- **View**: `OutputView.printStatics` → DTO 출력
- **Controller**: 흐름 관리

### 테스트
- 정상 당첨, 보너스 당첨, 미당첨 케이스 테스트 완료

---

## 6️⃣ 총 수익률 계산

### 절차
1. `LottoResult.calculateProfitRate(purchaseAmount)` 호출
2. DTO에 포함된 수익률 확인 (`LottoResultDto.getProfitRate`)
3. 출력 (`OutputView.printProfitRate`)

### MVC/SRP
- **Domain**: `LottoResult` → 수익률 계산
- **Service**: DTO 변환 포함
- **View**: DTO 기반 출력
- **Controller**: 흐름 관리

### 테스트
- 수익률 정상 계산 확인 완료

---

## 7️⃣ 공통 사항

- **상수화**: `Rank` enum, 상금, 매치 개수
- **에러 메시지**: `ErrorMessage` enum으로 관리
- **SRP**: 각 클래스 책임 명확히 분리
- **예외 처리**: 입력 단계에서 모두 처리
- **MVC**: 컨트롤러 → 입력/흐름, 뷰 → 출력, 도메인 → 검증/계산
- **테스트**: 입력 검증, 로직, 등수 판정, 수익률 계산 등 모두 완료  
