package tests.positive;



 /*
            Success = 101,
            Created = 102,
            Failed = 103,
            InvalidInput = 104,
            Forbidden = 105,
            Authorized = 106



Steps:

0) Необходима верификация.

1)Initialize
2)GetWorkflow
3)CreateBatch
4)AddBatchImage
5)SendBatch
5.1) 5-7 seconds waiting
5.2) GetBatches
6)LoadBatch (тот который был создан (последний))
7)GetBatchDocuments (взять guid документа)
8)SetDocumentCommentTest
9)Deinitialize

 */

public class SetDocumentFieldTest {
}
